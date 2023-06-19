import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoadingFullScreenComponent } from './loading-full-screen.component';

describe('LoadingFullScreenComponent', () => {
  let component: LoadingFullScreenComponent;
  let fixture: ComponentFixture<LoadingFullScreenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoadingFullScreenComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoadingFullScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
