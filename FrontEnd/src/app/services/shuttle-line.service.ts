import { Injectable } from '@angular/core';
import { ShuttleLine } from '../ShuttleLine';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ShuttleLineService {
  private http: HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
  }

  public getShuttleLines(): Observable<ShuttleLine[]> {
      return this.http.get<ShuttleLine[]>('http://localhost:8080/ptl');
  }

  public getShuttleLine(id: number): Observable<ShuttleLine> {
    return this.http.get<ShuttleLine>('http://localhost:8080/ptl/' + id);
  }
}
