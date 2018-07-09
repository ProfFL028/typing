
export class Page<T> {
  content: T[];
  first: boolean;
  last: true;
  number: number;
  numberOfElements: number;
  pageable: Pageable;
  size: number;
  totalElements: number;
  totalPages: number;
}

export class Pageable {
  sort: Sort;
  offset: number;
  pageSize: number;
  paged: boolean;
  unpaged: false;
}

export class Sort {
  sorted: boolean;
  unsorted: boolean;
}