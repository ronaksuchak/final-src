import { Component, PipeTransform } from '@angular/core';
import { DecimalPipe } from '@angular/common';
import { FormControl } from '@angular/forms';

import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';
import{ faculty } from '../../../models/faculty';
import { FacultyService } from '../../../services/faculty.service'
import { FacultyListComponent } from './faculty-list.component';

function search(text: string, pipe: PipeTransform): faculty[] {
    return faculties$.filter((faculty: { title: string; userId: any; body: any; }) => {
      const term = text.toLowerCase();
      return faculty.title.toLowerCase().includes(term)
          || pipe.transform(faculty.userId).includes(term)
          || pipe.transform(faculty.body).includes(term);
    });
  }
@Component({
    selector: 'app-faculty-list',
    templateUrl: './faculty-list.component.html',
    styleUrls: ['./faculty-list.component.css'],
    providers: [DecimalPipe]
  })
  export class NgbdTableFiltering {
  
    faculties$:Observable<faculty[]>;
    filter = new FormControl('');
  
    

    constructor(pipe: DecimalPipe) {
      this.faculties$ = this.filter.valueChanges.pipe(
        startWith(''),
        map(text => search(text, pipe))
      );
    }
  }