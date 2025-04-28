import { Routes } from '@angular/router';
import { LoginComponent } from './componentes/pages/login/login.component';
import { LogComponent } from './componentes/pages/login/log/log.component';
import { IndexComponent } from './componentes/pages/index/index.component';
import { RegisterComponent } from './componentes/pages/register/register.component';
import { MenuComponent } from './componentes/pages/menu/menu.component';
import { ServiciosComponent } from './componentes/pages/servicios/servicios.component';
import { InmediataComponent } from './componentes/pages/servicios/inmediata/inmediata.component';
import { PrevisionComponent } from './componentes/pages/servicios/prevision/prevision.component';
import { PlanesComponent } from './componentes/pages/servicios/planes/planes.component';
import { AdminComponent } from './componentes/pages/admin/admin.component';
import { RecordatoriosComponent } from './componentes/pages/admin/recordatorios/recordatorios.component';
import { ContentComponent } from './componentes/pages/content/content.component';
import { InfoComponent } from './componentes/pages/info/info.component';

export const routes: Routes = [
    
    {
        path: '',
        component : IndexComponent,
        children: [
            {
                path: '',
                component: ContentComponent
            },
            {
                path: 'login',
                component: LoginComponent,
            },
            {
                path: 'register',
                component: RegisterComponent
            },
            {
                path: 'info',
                component: InfoComponent
            }
        ]
    },
    {
        path: 'auth',
        component:  LogComponent,
        children: [
            {
                path: '',
                component: MenuComponent
            },
            {
                path: 'servicios',
                component: ServiciosComponent,
                children: [
                    {
                        path: 'inmediata',
                        component: InmediataComponent
                    },
                    {
                        path: 'prevision',
                        component: PrevisionComponent
                    },
                    {
                        path: 'planes',
                        component: PlanesComponent
                    }
                ]
            },
            {
                path: 'admin',
                component: AdminComponent,
                children: [
                    {
                        path: 'recordatorios',
                        component: RecordatoriosComponent
                    }
                ]
            }
        ]
    }
];
