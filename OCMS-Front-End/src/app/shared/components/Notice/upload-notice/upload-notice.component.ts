import { Component, OnInit } from '@angular/core';
import{ notice } from '../../../models/notice';
import { NoticeService } from '../../../services/notice.service'
import { Router } from '@angular/router';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-upload-notice',
  templateUrl: './upload-notice.component.html',
  styleUrls: ['./upload-notice.component.css']
})
export class UploadNoticeComponent implements OnInit {

  notice:notice=new notice();

  constructor(private noticeService:NoticeService,private router:Router) { }

  id: any;
  ngOnInit(): void {
  }

  saveNotice() {
    
    this.noticeService.create(this.notice).subscribe( data =>{
      console.log(data);
      this.goToNoticeList();
    },
    error => console.log(error));
  }

  goToNoticeList(){
    this.router.navigate(['/notice-list']);
  }
  
  onSubmit(){
    console.log(this.notice);
    this.notice.fauclty_id = this.id;
    this.saveNotice();
  }
}
