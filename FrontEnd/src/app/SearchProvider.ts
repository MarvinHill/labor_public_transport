import { SearchService } from "./services/search.service";

export interface SearchProvider{
    search(target : string, parent : SearchService) : void;
}