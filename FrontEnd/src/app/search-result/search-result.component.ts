import { Component, Input } from '@angular/core';
import { Searchable } from '../Searchable';

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css']
})
export class SearchResultComponent {
  @Input() item : Searchable;
}
