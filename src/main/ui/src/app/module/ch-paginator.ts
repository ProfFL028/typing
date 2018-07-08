import {MatPaginatorIntl} from '@angular/material';

const chGetRangeLabel = (page: number, pageSize: number, length: number): string {
  if (length == 0 || pageSize == 0) { return `0 至 ${length}`; }

  length = Math.max(length, 0);

  const startIndex = page * pageSize;

  // If the start index exceeds the list length, do not try and fix the end index to the end.
  const endIndex = startIndex < length ?
    Math.min(startIndex + pageSize, length) :
    startIndex + pageSize;

  return `${startIndex + 1} - ${endIndex} 至 ${length}`;
}

export function chPaginator() {
  const p = new MatPaginatorIntl();
  p.itemsPerPageLabel = '每页个数';
  p.nextPageLabel = '下一页';
  p.previousPageLabel = '上一页';
  p.firstPageLabel = '第一页';
  p.lastPageLabel = '最后一页';
  p.getRangeLabel = chGetRangeLabel;
  return p;
}