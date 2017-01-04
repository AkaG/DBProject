import React from 'react';
import { Provider as Store } from 'react-redux';
import { Router } from 'react-router';

import history from './history';
import routes  from './routes';
import store   from './store';

export default (
  <Store store={ store }>
    <Router
      history={ history }
      routes={ routes }
    />
  </Store>
);