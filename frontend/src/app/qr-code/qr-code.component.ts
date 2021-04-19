import { Component, OnInit } from '@angular/core';
import { NgxQrcodeElementTypes, NgxQrcodeErrorCorrectionLevels } from '@techiediaries/ngx-qrcode';
import { ElementRef, ViewChild, Renderer2 } from '@angular/core';  

@Component({
  selector: 'app-qr-code',
  templateUrl: './qr-code.component.html',
  styleUrls: ['./qr-code.component.css']
})
export class QrCodeComponent implements OnInit {

  elementType = NgxQrcodeElementTypes.URL;
  correctionLevel = NgxQrcodeErrorCorrectionLevels.HIGH;
  value = 'Apurva';

  constructor() {
    /*this.level = "L";
    //this.qrCodeVal = "QR code string value";
    //this.width = 200;*/
  }

  ngOnInit(): void {
  }
}

/*
  public qrCodeVal: string = "";
  public level: "L" | "M" | "Q" | "H";
  public width: number;

  updateLevel(newValue: "L" | "M" | "Q" | "H") {
    this.level = newValue;
  }

  updateQrInfo(newValue: string) {
    this.qrCodeVal = newValue;
  }

  updateWidth(newValue: number) {
    this.width = newValue;
  }

  qrcodename : string='';
  title = 'generate-qrcode';
  elementType: 'url' | 'canvas' | 'img' = 'url';
  value: string='';
  display = false;
  href : string='';

  generateQRCode(){
    if(this.qrcodename == ''){
      this.display = false;
      alert("Please enter the name");
      return;
    }
    else{
      this.value = this.qrcodename;
     // this.value = 'http://172.17.0.1:4200/';
      this.display = true;
    }
  }
  downloadImage(){
    this.href = document.getElementsByTagName('img')[0].src;
    console.log(document.getElementsByTagName('img')[1].src)
    console.log(this.value)
  }*/