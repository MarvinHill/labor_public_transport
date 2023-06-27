import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PreisService {


  //Ticket Preise//

  private preiseTagesKarten: { kinder: string, jungeErwachsene: number, erwachsene: number, gruppen: number, beguenstigte: number } = {
    kinder: "Frei",
    jungeErwachsene: 11.00,
    erwachsene: 28.00,
    gruppen: 25.00,
    beguenstigte: 18.00
  };

  private preiseZweiTagesKarten: { kinder: string, jungeErwachsene: number, erwachsene: number, gruppen: number, beguenstigte: number } = {
    kinder: "Frei",
    jungeErwachsene: 17.00,
    erwachsene: 43.00,
    gruppen: 38.00,
    beguenstigte: 28.00
  };

  private preiseDauerkarten: { kinder: string, jungeErwachsene: number, erwachsene: number, gruppen: string, beguenstigte: number } = {
    kinder: "Frei",
    jungeErwachsene: 65.00,
    erwachsene: 145.00,
    gruppen: "-",
    beguenstigte: 95.00
  };

  //Parken Preise//
  private preisShuttleParkplatz: { onlineVerkauf: number, vorOrtVerkauf: number} = {
    onlineVerkauf: 8.50,
    vorOrtVerkauf: 9.50
  };

  //BaWü Ticket//
  private preisBaWueTicket: { amAutomat: number, amTicketschalter: number} = {
    amAutomat: 40.00,
    amTicketschalter: 42.00
  };

  constructor() { }

  //Formats Preis: 2 decimal numbers and . -> ,
  private formatPreis(preis: any): any {
    if (typeof preis === 'number') {
      return preis.toFixed(2).replace('.',',');
    } else {
      return preis;
    }
  }

  //Ticket Preise Getter und Setter

  getPreisTagesKarten(fuer: string): any {
    const preis = this.preiseTagesKarten[fuer];
    return this.formatPreis(preis);
  }

  setPreisTagesKarten(fuer: string, preis: any): void {
    preis = parseFloat(preis).toFixed(2);
    this.preiseTagesKarten[fuer] = preis;
  }

  getPreisZweiTagesKarten(fuer: string): any {
    const preis = this.preiseZweiTagesKarten[fuer];
    return this.formatPreis(preis);
  }

  setPreisZweiTagesKarten(fuer: string, preis: any): void {
    preis = parseFloat(preis).toFixed(2);
    this.preiseZweiTagesKarten[fuer] = preis;
  }

  getPreisDauerkarten(fuer: string): any {
    const preis = this.preiseDauerkarten[fuer];
    return this.formatPreis(preis);
  }

  setPreisDauerkarten(fuer: string, preis: any): void {
    preis = parseFloat(preis).toFixed(2);
    this.preiseDauerkarten[fuer] = preis;
  }

 //Shuttle Parkplatz Getter und Setter

  getPreisShuttleParkplatz(fuer: string): any {
    const preis = this.preisShuttleParkplatz[fuer];
    return this.formatPreis(preis);
  }

  setPreisShuttleParkplatz(fuer: string, preis: any): void {
    preis = parseFloat(preis).toFixed(2);
    this.preisShuttleParkplatz[fuer] = preis;
  }

  //BaWü Ticket Getter und Setter

  getpreisBaWueTicket(fuer: string): any {
    const preis = this.preisBaWueTicket[fuer];
    return this.formatPreis(preis);
  }

  setpreisBaWueTicket(fuer: string, preis: any): void {
    preis = parseFloat(preis).toFixed(2);
    this.preisBaWueTicket[fuer] = preis;
  }
}
