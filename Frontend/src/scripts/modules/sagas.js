import {
  fetchMovieRentalsListener,
  fetchMovieRentalListener,
} from './movieRentals/saga';

export default function* sagas() {
  yield [
    fetchMovieRentalsListener(),
    fetchMovieRentalListener(),
  ];
}