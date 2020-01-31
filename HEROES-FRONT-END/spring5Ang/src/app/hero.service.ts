import { Injectable } from '@angular/core';
import { Hero } from './hero';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { MessageService } from './message.service';
import { catchError, map, tap } from 'rxjs/operators';

// his marks the class as one that participates in the dependency injection system.


interface GetResponse {
  _embedded: {
    heroes: Hero[];
    _links: {self: {href: string}};
  };
}

const httpOptions: { headers: HttpHeaders } = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class HeroService {



  // public API = '//localhost:8080';
  // public PRODUCT_API = this.API + '/api';
  // public SEARCH_API = this.PRODUCT_API + '/search';
  // public SEARCH_FULL_API = this.PRODUCT_API + '/searchfull';

  private heroesUrl = 'http://localhost:8080/api';  // URL to web api

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };



  constructor(
    private http: HttpClient,
    private messageService: MessageService) {

  }


  searchHeroes(term: string): Observable<Hero[]> {

    if (!term.trim()) {

      return of([]);
    }
    return this.http.get<Hero[]>(`${this.heroesUrl + '/searchByName'}/?name=${term}`).pipe(
      tap(_ => this.log(`found heroes matching "${term}"`)),
      catchError(this.handleError<Hero[]>('searchHeroes', []))
    );
  }


// *********************************************************************
getHero(id: number): Observable<Hero> {

  const url = `${this.heroesUrl}/searchByID/?id=${id}`;
  return this.http.get<Hero>(url).pipe(
    tap(_ => this.log(`fetched hero id=${id}`)),
    catchError(this.handleError<Hero>(`getHero id=${id}`))
  );
}

// HeroService.getHeroes() must have an asynchronous signature of some kind.
// this is the main entry point for the DATA to this app
// To catch errors, you "pipe" the observable result from http.get() through an RxJS catchError() operator.
// The HeroService methods will tap into the flow of observable values and send a message, via the log() method,
// to the message area at the bottom of the page.
getHeroes(): Observable<Hero[]> {
  return this.http.get<Hero[]>(this.heroesUrl + '/getAllProducts')
    .pipe(
      tap(_ => this.log('fetched heroes')),
      catchError(this.handleError<Hero[]>('getHeroes', []))
    );
}



  private log(message: string) {
    this.messageService.add(`HeroService: ${message}`);
  }

  // The heroes web API expects a special header in HTTP save requests.
  // That header is in the httpOptions constant defined in the HeroService.
  updateHero(hero: Hero): Observable<any> {
    const url = `${this.heroesUrl}/${hero.id}`;
    return this.http.put(url, hero, this.httpOptions).pipe(
      tap(_ => this.log(`updated hero id=${hero.id}`)),
      catchError(this.handleError<any>('updateHero'))
    );
  }

/** POST: add a new hero to the server */
addHero(hero: Hero): Observable<Hero> {
  return this.http.post<Hero>(this.heroesUrl, hero, this.httpOptions).pipe(
    tap((newHero: Hero) => this.log(`added hero w/ id=${newHero.id}`)),
    catchError(this.handleError<Hero>('addHero'))
  );
}

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  /** DELETE: delete the hero from the server */
deleteHero(hero: Hero | number): Observable<Hero> {
  const id = typeof hero === 'number' ? hero : hero.id;
  const url = `${this.heroesUrl}/${id}`;

  return this.http.delete<Hero>(url, this.httpOptions).pipe(
    tap(_ => this.log(`deleted hero id=${id}`)),
    catchError(this.handleError<Hero>('deleteHero'))
  );
}


}
