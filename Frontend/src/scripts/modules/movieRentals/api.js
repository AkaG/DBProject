import fetch from 'utils/fetch';

export function fetchMovieRentals() {
  return fetch('movierental', 'GET');
}

export function fetchMovieRental(id) {
  return fetch(`movierental/${ id }`, 'GET');
}