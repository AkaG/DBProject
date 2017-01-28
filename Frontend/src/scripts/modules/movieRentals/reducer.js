import { consts } from './actions';

export default function movieRentalsReducer(state = {
  movieRental: {},
  movieRentals: []
}, action) {
  switch(action.type) {
    case consts.fetchMovieRentalsSuccess: {
      const { movieRentals } = action;

      return {
        ...state,
        movieRentals
      };
    }

    case consts.fetchMovieRentalSuccess: {
      const { movieRental } = action;

      return {
        ...state,
        movieRental
      };
    }

    default: {
      return state;
    }
  }
}