import { Component, AfterViewInit } from '@angular/core';
import {Router} from '@angular/router';

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

    const updateDots = (currentDot, targetDot) => {
      currentDot.classList.remove('current-slide');
      targetDot.classList.add('current-slide');
    }

    const hideShowArrows = (slides, prevButton, nextButton, targetIndex) => {
      if(targetIndex === 0){
        prevButton.classList.add('is-hidden');
        nextButton.classList.remove('is-hidden');
      } else if (targetIndex === slides.length - 1){
        prevButton.classList.remove('is-hidden');
        nextButton.classList.add('is-hidden');
      } else {
        prevButton.classList.remove('is-hidden');
        nextButton.classList.remove('is-hidden');
      }
    }

    nextButton.addEventListener('click', e => {
      const currentSlide = track.querySelector('.current-slide') as HTMLElement;
      const nextSlide = currentSlide.nextElementSibling as HTMLElement;
      const currentDot = dotsNav.querySelector('.current-slide') as HTMLElement;
      const nextDot = currentDot.nextElementSibling;
      const nextIndex = slides.findIndex(slide => slide === nextSlide);
      moveToSlide(track, currentSlide, nextSlide)
      updateDots(currentDot, nextDot);
      hideShowArrows(slides, prevButton, nextButton, nextIndex);
    })

    prevButton.addEventListener('click', e => {
      const currentSlide = track.querySelector('.current-slide') as HTMLElement;
      const prevSlide = currentSlide.previousElementSibling as HTMLElement;
      const currentDot = dotsNav.querySelector('.current-slide') as HTMLElement;
      const prevDot = currentDot.previousElementSibling;
      const prevIndex = slides.findIndex(slide => slide === prevSlide);
      moveToSlide(track, currentSlide, prevSlide);
      updateDots(currentDot, prevDot);
      hideShowArrows(slides, prevButton, nextButton, prevIndex);
    });

    dotsNav.addEventListener('click', (e: MouseEvent) => {
      const targetDot = (e.target as Element).closest('button');

      if(!targetDot) return;

      const currentSlide = track.querySelector('.current-slide') as HTMLElement;
      const currentDot = dotsNav.querySelector('.current-slide') as HTMLElement;
      const targetIndex = dots.findIndex(dot => dot === targetDot);
      const targetSlide = slides[targetIndex];

      moveToSlide(track, currentSlide, targetSlide);
      updateDots(currentDot, targetDot);
      hideShowArrows(slides, prevButton, nextButton, targetIndex);
     
     
    });

    track.addEventListener('click', () => {
      open('/travelinfo', '_blank', 'width=400,height=800');
    });
  

  }
}






