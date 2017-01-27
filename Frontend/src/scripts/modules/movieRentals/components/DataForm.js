import React, { Component, PropTypes } from 'react';

import { Input, Button } from 'ui';

export default class DataForm extends Component {
  static propTypes = {
    data: PropTypes.object,
  };

  constructor() {
    super();

    this.state = {
      data: {
        address: {}
      },
    };
  }

  onChange(name, value) {
    this.setState({
      data: {
        ...this.state.data,
        [name]: value,
      },
    });
  }

  onAddressChange(name, value) {
    this.setState({
      data: {
        ...this.state.data,
        address: {
          ...this.state.data.address,
          [name]: value,
        }
      },
    });
  }

  componentWillReceiveProps(nextProps) {
    this.setState({
      data: {
        ...this.state.data,
        ...nextProps.data
      },
    });
  }

  render() {
    const {
      data,
    } = this.state;

    const {
      address
    } = data;

    return (
      <section className="form">
        <Input type="text" label="Name" name="name" value={ data.name } onChange={ this.onChange.bind(this, 'name') } maxLength={ 16 } />
        <Input type="text" label="Phone" name="phone" value={ data.phone } onChange={ this.onChange.bind(this, 'phone') } maxLength={ 16 } />
        <Input type="text" label="Street" name="address" value={ address.street } onChange={ this.onAddressChange.bind(this, 'street') } maxLength={ 16 } />
        <Input type="text" label="Street number" name="streetNumber" value={ address.streetNumber } onChange={ this.onAddressChange.bind(this, 'streetNumber') } maxLength={ 16 } />
        <Input type="text" label="Postal code" name="postalCode" value={ address.postalCode } onChange={ this.onAddressChange.bind(this, 'postalCode') } maxLength={ 16 } />
        <Input type="text" label="Country" name="countryName" value={ address.countryName } onChange={ this.onAddressChange.bind(this, 'countryName') } maxLength={ 16 } />
        <Input type="text" label="Country code" name="countryCode" value={ address.countryCode } onChange={ this.onAddressChange.bind(this, 'countryCode') } maxLength={ 16 } />
        <Button icon="bookmark" label="Save" raised primary />
      </section>
    );
  }
}