import React from "react";
import ReactDOMServer from "react-dom/server";
import { StaticRouter } from "react-router-dom/server";
import App from "./App";

export function render(req) {
  const context = {};

  const html = ReactDOMServer.renderToString(
    <React.StrictMode>
      <StaticRouter location={req.url} context={context} >
        <App />
      </StaticRouter>
    </React.StrictMode>
  );
  return { html, context };
}
