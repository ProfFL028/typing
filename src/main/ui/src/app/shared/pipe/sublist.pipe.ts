import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sublist',
  pure: false
})

export class SublistPipe implements PipeTransform {
  transform(items: any[], beginIndex: number, length: number): any {
    let newItems = [];

    if (items !== undefined && items.length > 0) {
      for (let i = 0; i < length; i++) {
        if (items.length >= (beginIndex + i)) {
          newItems.push(items[beginIndex + i]);
        }
      }
    }
    return newItems;
  }
}
