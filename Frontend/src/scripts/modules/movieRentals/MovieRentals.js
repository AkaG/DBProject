import React, { Component } from 'react';
import { connect } from 'react-redux';

import Main from 'components/main';

import DataForm from './components/DataForm';
import DataTable from './components/DataTable';

import { fetchMovieRentals, fetchMovieRental } from './actions';

class MovieRentals extends Component {
  componentDidMount() {
    const { fetch } = this.props;

    fetch();
  }

  onEditButton(id) {
    const { fetchOne } = this.props;

    fetchOne(id);
  }

  render() {
    const {
      movieRental,
      movieRentals,
    } = this.props;

    return (
      <Main>
        <DataForm
          data={ movieRental }
        />
        <DataTable
          data={ movieRentals }
          onEdit={ this.onEditButton.bind(this) }
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