import { Component, OnInit } from '@angular/core';
import{ notes } from '../../../models/notes';
import { NotesService } from '../../../services/notes.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-notes-list',
  templateUrl: './notes-list.component.html',
  styleUrls: ['./notes-list.component.css']
})
export class NotesListComponent implements OnInit {

  notes:notes[]=[];

  constructor(private notesService:NotesService,private router:Router) { }

  ngOnInit(): void {
    this.getNotes();
  }

  getNotes(){
    this.notesService.getAll().subscribe(data=>{
      console.log(data);
      this.notes=data;
    });
  }

}
