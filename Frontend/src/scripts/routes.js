import React from 'react';
import { IndexRedirect, Route } from 'react-router';

import MovieRentals from 'modules/movieRentals';

import paths from 'consts/paths';

export default (
  <Route path={ paths.index }>
    <IndexRedirect
      to={ paths.movieRentals }
    />

    <Route
      component={ MovieRentals }
      path={ paths.movieRentals }
    />

  </Route>
);