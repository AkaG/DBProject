import * as d3 from 'd3';

export function locale() {
  d3.formatDefaultLocale({
    currency: [
      '',
      ' €',
    ],
    decimal: '.',
    grouping: [
      3,
    ],
    thousands: ' ',
  });
}

export function currency(value) {
  locale();

  return d3.format('$,.0d')(value);
}

export function date(value) {
  return d3.timeFormat('%Y-%m-%d')(value);
}

export function difference(value) {
  locale();

  return (value >= 0 ? '+' : '') + d3.format('.1%')(value / 100);
}

export function number(value) {
  locale();

  return d3.format(',.0d')(value);
}

export function percent(value) {
  locale();

  return d3.format('.0%')(value / 100);
}

export function time(value) {
  return d3.timeFormat('%H:%M:%S')(value);
}

export function daysToWeeksAndDays(value) {
  return {
    weeks: Math.floor(value / 7),
    days: value % 7,
  };
}