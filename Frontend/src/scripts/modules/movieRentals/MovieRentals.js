import React, { Component } from 'react';
import { connect } from 'react-redux';

import Main from 'components/main';

import DataForm from './components/DataForm';
import DataTable from './components/DataTable';

import { fetchMovieRentals, fetchMovieRental } from './actions';

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

  componentDidMount() {
    const { fetch } = this.props;

    fetch();
  }

  render() {
    const {
      movieRental,
      movieRentals,
    } = this.props;

    const { data } = this.state;

    return (
      <Main>
        <DataForm
          data={ data }
        />
        <DataTable
          data={ movieRentals }
        />
      </Main>
    );
  }
}

function mapStateToProps(state) {
  const {
    movieRentals,
    movieRental
  } = state.movieRentals;

  return {
    movieRentals,
    movieRental
  };
}

const mapDispatchToProps = {
  fetch: fetchMovieRentals,
  fetchOne: fetchMovieRental,
};


export default connect(mapStateToProps, mapDispatchToProps)(MovieRentals);