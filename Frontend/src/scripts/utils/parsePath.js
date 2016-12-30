import { keys } from 'lodash';

export default function parsePath(path, params = {}) {
  let parsedPath = path;

  keys(params).forEach((key) => {
    parsedPath = parsedPath.replace(new RegExp(`:${ key }`, 'g'), params[key]);
  });

  parsedPath = parsedPath.replace(/:\w+/g, '');
  parsedPath = parsedPath.replace(/\(\/\)/g, '');
  parsedPath = parsedPath.replace(/\(|\)/g, '');
  parsedPath = parsedPath.replace(/\/\//g, '/');

  return parsedPath;
}