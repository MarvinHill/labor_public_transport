import { Component, Input } from '@angular/core';
import { Searchable } from '../Searchable';

@Component({
  selector: 'app-search-category',
  templateUrl: './search-category.component.html',
  styleUrls: ['./search-category.component.css']
})
export class SearchCategoryComponent {

  @Input() category : string = "";
  @Input() items : Searchable[] = [];
  

}
