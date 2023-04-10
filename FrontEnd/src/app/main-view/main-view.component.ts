import { Component, AfterViewInit } from '@angular/core';

@Component({
  selector: 'app-main-view',
  templateUrl: './main-view.component.html',
  styleUrls: ['./main-view.component.css']
})
export class MainViewComponent implements AfterViewInit {

  ngAfterViewInit() {
    const track = document.querySelector('.carousel__track') as HTMLElement;
    const slides = Array.from(track.children) as HTMLElement[];
    const nextButton = document.querySelector('.carousel__button--right');
    const prevButton = document.querySelector('.carousel__button--left');
    const dotsNav = document.querySelector('.carousel__nav');
    const dots = Array.from(dotsNav.children);

    const slideWidth = slides[0].getBoundingClientRect().width;
    
    const setSlidePosition = (slide, index) => {
      slide.style.left = slideWidth * index + 'px';
    };
    slides.forEach(setSlidePosition);

    const moveToSlide = (track, currentSlide, targetSlide) => {
      track.style.transform = 'translateX(-' + targetSlide.style.left +  ')';
      currentSlide.classList.remove('current-slide');
      targetSlide.classList.add('current-slide')
    }

  

    nextButton.addEventListener('click', e => {
      const currentSlide = track.querySelector('.current-slide') as HTMLElement;
      const nextSlide = currentSlide.nextElementSibling as HTMLElement;
      
      moveToSlide(track, currentSlide, nextSlide)
    })

    prevButton.addEventListener('click', e => {
      const currentSlide = track.querySelector('.current-slide') as HTMLElement;
      const prevSlide = currentSlide.previousElementSibling as HTMLElement;

      moveToSlide(track, currentSlide, prevSlide);
    })

   



  }

}






