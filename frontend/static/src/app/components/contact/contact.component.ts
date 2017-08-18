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

  isInvalidEmail: Boolean = false;


  ngOnInit(){
    this.nameCtrl = this.contactFormBuilder.control('',Validators.required);
    this.emailCtrl = this.contactFormBuilder.control('',[Validators.required, Validators.email]);
    this.subjectCtrl = this.contactFormBuilder.control('',Validators.required);
    this.messageCtrl = this.contactFormBuilder.control('',Validators.required);

    this.createForm();
  }

  constructor(private fb: FormBuilder){ 
    this.contactFormBuilder = fb;    
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

  focusEmail(){
    this.emailCtrl.setErrors(null);
    this.isInvalidEmail = false;
  }

  verifyEmail(){
    if (!this.emailCtrl.hasError('required') && (this.emailCtrl.hasError('email'))){      
      this.isInvalidEmail = true;
    }else{
      this.isInvalidEmail = false;
    }
  }
}