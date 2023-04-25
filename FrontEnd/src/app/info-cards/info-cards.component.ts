import { AfterViewInit, Component } from '@angular/core';

@Component({
  selector: 'app-info-cards',
  templateUrl: './info-cards.component.html',
  styleUrls: ['./info-cards.component.css']
})
export class InfoCardsComponent implements AfterViewInit {
  ngAfterViewInit() {
  const accordion = document.querySelector(".accordion") as HTMLElement;

  accordion.addEventListener('click', (e) =>{
    const activePanel = (e.target as HTMLElement).closest(".accordion-panel");
    if(!activePanel) return;
    toggleAccordion(activePanel);
  });

  function toggleAccordion(panelToActivate){
    const buttons = Array.from(panelToActivate.parentElement.querySelectorAll("button")) as HTMLElement[];
    const contents = Array.from(panelToActivate.parentElement.querySelectorAll('.accordion-content')) as HTMLElement[];
    
    buttons.forEach((button)=>{
      button.setAttribute('aria-expanded','false');
    });

    buttons.forEach((content)=>{
      content.setAttribute('aria-hidden','true');
    });

    panelToActivate.querySelector('button').setAttribute('aria-expanded', true);
    panelToActivate.querySelector('.accordion-conent').setAttribute('aria-hidden', false);
  }

  }
}
