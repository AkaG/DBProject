import React, { Component } from 'react';

import Main from 'components/main';

import DataForm from './components/DataForm';
import DataTable from './components/DataTable';

const users = [
  {
    name: 'Test Name 100',
    phone: '+48 234 234 234',
    address: 'Poland',
    staff: 20,
    inventories: 100,
  },
  {
    name: 'Test Name 100',
    phone: '+48 234 234 234',
    address: 'Poland',
    staff: 20,
    inventories: 100,
  },
  {
    name: 'Test Name 100',
    phone: '+48 234 234 234',
    address: 'Poland',
    staff: 20,
    inventories: 100,
  },
];

class MovieRentals extends Component {
  constructor() {
    super();

    this.state = {
      data: {
        name: '',
        phone: '',
        address: '',
        staff: 0,
        inventories: 0,
      },
    };
  }

  handleChange(name, value) {
    this.setState({
      data: {
        [name]: value,
      },
    });
  }

  render() {
    const { data } = this.state;

    return (
      <Main>
        <DataForm
          data={ data }
          handleChange={ this.handleChange.bind(this) }
        />
        <DataTable
          data={ users }
        />
      </Main>
    );
  }
}

export default MovieRentals;