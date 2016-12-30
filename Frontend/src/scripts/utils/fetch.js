import isomorphicFetch from 'isomorphic-fetch';

import consts from 'consts/api';

export default function fetch(url, method, body) {
  return isomorphicFetch(
    `${ consts.url }/${ url }`,
    {
      method,
      body: JSON.stringify(body),
      credentials: 'include',
      headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json',
      },
    }
  ).then(
    (response) => {
      if(response.status >= 400) {
        throw new Error(response.statusText);
      }

      return response.text().then((text) => {
        return text ? JSON.parse(text) : {};
      });
    }
  );
}