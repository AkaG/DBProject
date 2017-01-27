import { takeLatest } from 'redux-saga';
import { call, put } from 'redux-saga/effects';

import { consts } from './actions';

import * as api from './api';

function* fetchMovieRentals() {
  try {
    const movieRentals = yield call(api.fetchMovieRentals);

    yield put({
      movieRentals,
      type: consts.fetchMovieRentalsSuccess
    });
  }

  catch(error) {
    console.error(error);

    yield put({
      type: consts.fetchMovieRentalsFailure
    });
  }
}

function* fetchMovieRental(action) {
  const { id } = action;

  try {
    const movieRental = yield call(api.fetchMovieRental, id);

    yield put({
      movieRental,
      type: consts.fetchMovieRentalSuccess
    });
  }

  catch(error) {
    console.error(error);

    yield put({
      type: consts.fetchMovieRentalFailure
    });
  }
}

export function* fetchMovieRentalsListener() {
  yield takeLatest(consts.fetchMovieRentalsRequest, fetchMovieRentals);
}

export function* fetchMovieRentalListener() {
  yield takeLatest(consts.fetchMovieRentalRequest, fetchMovieRental);
}