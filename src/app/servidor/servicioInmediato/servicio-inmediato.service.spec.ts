import { TestBed } from '@angular/core/testing';

import { ServicioInmediatoService } from './servicio-inmediato.service';

describe('ServicioInmediatoService', () => {
  let service: ServicioInmediatoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServicioInmediatoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
