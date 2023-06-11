import { Searchable } from "./Searchable";

export class InfoSearchResult implements Searchable{
    category: string;
    displayText: string;
    searchAction: Function;
}