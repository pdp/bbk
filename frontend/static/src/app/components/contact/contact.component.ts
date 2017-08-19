import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';


@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent implements OnInit{
  
  contactForm: FormGroup;

  contactFormBuilder : FormBuilder;

  nameCtrl: FormControl;
  emailCtrl: FormControl;
  subjectCtrl: FormControl;
  messageCtrl: FormControl;

  contactTitle:String = 'Contact persoon: Peter De Brombeer';

  ngOnInit(){
    this.nameCtrl = this.fb.control('',Validators.required);
    this.emailCtrl = this.fb.control('',[Validators.required, Validators.email]);
    this.subjectCtrl = this.fb.control('',Validators.required);
    this.messageCtrl = this.fb.control('',Validators.required);

    this.createForm();
  }

  constructor(private fb: FormBuilder){ 
   }

   createForm(){
     this.contactForm = this.fb.group({
       name: this.nameCtrl,
       email:this.emailCtrl,
       subject:this.subjectCtrl,
       message:this.messageCtrl
     })
   }

  handle(){
    console.log('handle action');
    console.log(this.contactForm.value);
  }
}