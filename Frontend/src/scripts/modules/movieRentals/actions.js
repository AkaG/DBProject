export const consts = {
  fetchMovieRentalsRequest: 'FETCH_MOVIE_RENTALS_REQUEST',
  fetchMovieRentalsSuccess: 'FETCH_MOVIE_RENTALS_SUCCESS',
  fetchMovieRentalsFailure: 'FETCH_MOVIE_RENTALS_FAILURE',

  fetchMovieRentalRequest: 'FETCH_MOVIE_RENTAL_REQUEST',
  fetchMovieRentalSuccess: 'FETCH_MOVIE_RENTAL_SUCCESS',
  fetchMovieRentalFailure: 'FETCH_MOVIE_RENTAL_FAILURE',
};

export function fetchMovieRentals() {
  return {
    type: consts.fetchMovieRentalsRequest,
  };
}

export function fetchMovieRental(id) {
  return {
    id,
    type: consts.fetchMovieRentalRequest,
  };
}