import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InmediataComponent } from './inmediata.component';

describe('InmediataComponent', () => {
  let component: InmediataComponent;
  let fixture: ComponentFixture<InmediataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InmediataComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InmediataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
