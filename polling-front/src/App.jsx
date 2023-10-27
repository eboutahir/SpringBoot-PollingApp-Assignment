import { useState } from 'react'
import './index.css';
import { Routes, Route } from "react-router-dom";
import { CreateQuiz, HelloComponent, QuizList } from './Pages'

function App() {

  return (
    <>
      <Routes>
      <Route index element={<HelloComponent />} />
      <Route path="/create" element={<CreateQuiz />} />
      <Route path="/quiz" element={<QuizList />} />
    </Routes>
    </>
  )
}

export default App
