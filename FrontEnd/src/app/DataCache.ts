import { Observable, lastValueFrom } from "rxjs";

const MILLISECOND_PER_SECOND = 1000;
const SECOND_PER_MINUTE = 60;
/**
 * An Object that keeps count of when it was last called and serves a chached copy of its data from when there was a previous call for the same data.
 */
export class DataCache<T> {
    private dataCache : T[];
    private lastRequestDate : Date;

    public cacheTimeInMin = 1;

    
    /**
     * A function that takes a previous call for a resource for example a api and serves it from a cache. When the data gets stale after the cacheTimeInMin is overdraft it makes a new request.
     * @param func Function which return Objects should be cached.
     * @returns An Object Array of type T, that would be normally returned by the parameter function.
     */
    public async pipeRequest<A extends Function>(func : A ) : Promise<T[]>{

        if(this.lastRequestDate == null){
            await this.doRequestAndResetDate<A>(func);
        }
        if((new Date().valueOf() - this.lastRequestDate.valueOf()) > this.cacheTimeInMin  * SECOND_PER_MINUTE * MILLISECOND_PER_SECOND){
            await this.doRequestAndResetDate<A>(func);
        }

        return new Promise<T[]>((resolve, reject) => {
            resolve(this.dataCache);
        });
    }


    private async doRequestAndResetDate<A extends Function>(func: A) : Promise<T[]>{
        this.lastRequestDate = new Date();
        return func().subscribe((value) => {
            this.dataCache = value;
        }).first().toPromise();
    }
}
