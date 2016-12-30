import { delay } from 'redux-saga';
import { call } from 'redux-saga/effects';

export default function* wait(time) {
  yield call(delay, time);
}