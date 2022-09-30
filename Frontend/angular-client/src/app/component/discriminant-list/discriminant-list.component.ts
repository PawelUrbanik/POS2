import { Component, OnInit } from '@angular/core';
import { Discriminant } from 'src/app/common/discriminant';
import { DiscriminantService } from 'src/app/services/discriminant.service';

@Component({
  selector: 'app-discriminant-list',
  templateUrl: './discriminant-list.component.html',
  styleUrls: ['./discriminant-list.component.css']
})
export class DiscriminantListComponent implements OnInit {

  constructor(private discriminantService: DiscriminantService) { }

  discriminants: Discriminant[] = [];

  ngOnInit(): void {
    this.discriminantService.getDiscriminant().subscribe(data =>{
        this.discriminants = data;
    });

    console.log(this.discriminants);
  }



}
