import { PropTypes } from 'react';

import { propTypes } from 'ui/utils';

export default {
  ...propTypes,
  channel: PropTypes.shape({
    budget: PropTypes.number,
    children: PropTypes.array,
    id: PropTypes.string.isRequired,
    label: PropTypes.string.isRequired,
    multiplier: PropTypes.number.isRequired,
  }),
  children: PropTypes.oneOfType([
    PropTypes.element,
    PropTypes.array,
  ]),
  listDefaultFilters: PropTypes.shape({
    search: PropTypes.objectOf(
      PropTypes.string
    ),
    sort: PropTypes.objectOf(
      PropTypes.string
    ),
  }),
  listFilters: PropTypes.shape({
    search: PropTypes.arrayOf(
      PropTypes.string
    ),
    sort: PropTypes.arrayOf(
      PropTypes.string
    ),
  }),
  product: PropTypes.shape({
    budget: PropTypes.number,
    id: PropTypes.string.isRequired,
    label: PropTypes.string.isRequired,
    multiplier: PropTypes.number.isRequired,
  }),
};