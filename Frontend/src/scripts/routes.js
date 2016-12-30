
import React from 'react';
import { IndexRedirect, Route } from 'react-router';

import Demo from 'modules/demo';

import paths from 'consts/paths';

export default (
  <Route path={ paths.index }>
    <IndexRedirect
      to={ paths.demo }
    />

    <Route
      component={ Demo }
      path={ paths.demo }
    />

  </Route>
);