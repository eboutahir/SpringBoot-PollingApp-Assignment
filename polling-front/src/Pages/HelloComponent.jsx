import React from "react";
import { CardButton } from "../Components";
import "./HelloComponent.css"; // Create a CSS file for custom styling

function HelloComponent() {
  return (
    <div className="min-h-screen flex items-center justify-center bg-gray-100 relative">
      <div className="text-center">
        <h1 className="text-4xl font-bold text-indigo-800 mb-4 move-title">
          Hello in our quiz creator
        </h1>
        <div className="flex justify-center gap-6">
          <CardButton title="Create a quiz" linkTo="create" />
          <CardButton title="Try to solve a quiz" linkTo="quiz" />
        </div>
      </div>
      
    </div>
  );
}

export default HelloComponent;
