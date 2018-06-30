import {RangePipe} from '../shared/pipe/range.pipe';
import {NgModule} from '@angular/core';
import {SublistPipe} from '../shared/pipe/sublist.pipe';

@NgModule({
  declarations: [
    RangePipe,
    SublistPipe
  ],
  exports: [
    RangePipe,
    SublistPipe
  ]
})
export class CustomModule {}
