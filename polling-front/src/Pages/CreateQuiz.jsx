import React, { useState } from 'react';
import "./CreateQuiz.css";


function CreateQuiz() {
  const [quizData, setQuizData] = useState({
    title: '',
    questions: [
      {
        question: '',
        answers: [
          { answer: '', is_correct: false },
          { answer: '', is_correct: false },
          { answer: '', is_correct: false },
          { answer: '', is_correct: false },
        ],
      },
    ],
  });

  const handleInputChange = (e, questionIndex, answerIndex) => {
    const { name, value, type, checked } = e.target;
    const updatedQuizData = { ...quizData };
    if (type === 'checkbox') {
      updatedQuizData.questions[questionIndex].answers[answerIndex].is_correct = checked;
    } else {
      updatedQuizData.questions[questionIndex][name] = value;
    }
    setQuizData(updatedQuizData);
  };

  const handleAddQuestion = () => {
    setQuizData({
      ...quizData,
      questions: [
        ...quizData.questions,
        {
          question: '',
          answers: [
            { answer: '', is_correct: false },
            { answer: '', is_correct: false },
            { answer: '', is_correct: false },
            { answer: '', is_correct: false },
          ],
        },
      ],
    });
  };

  const handleSubmit = () => {
    // Create the data you want to send to the server
    const quizDataToSend = {
      title: quizData.title,
      questions: quizData.questions,
    };
    
    console.log(quizDataToSend);

    fetch('http://localhost:8080/quiz', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(quizDataToSend),
    })
      .then((response) => {
        if (response.ok) {
          return response.json();
        } else {
          throw new Error('Failed to add the quiz');
        }
      })
      .then((data) => {
        console.log('Quiz added. Quiz ID:', data.id);
      })
      .catch((error) => {
        console.error('Error:', error);
      });
  };

  return (
    <div className="max-w-lg mx-auto p-10 bg-white rounded-lg shadow-md">
      <h1 className="text-4xl font-bold text-indigo-800 mb-4 move-title ">Create Quiz</h1>
      <input
        type="text"
        name="title"
        placeholder="Title"
        value={quizData.title}
        onChange={(e) => setQuizData({ ...quizData, title: e.target.value })}
        className="w-full border rounded-md p-4 mb-10 focus:outline-none focus:ring focus:border-blue-800 "
      />

      {quizData.questions.map((question, questionIndex) => (
        <div key={questionIndex} className="mb-4 border-b-2 pb-4">
          <input
            type="text"
            name="question"
            placeholder={`Question ${questionIndex + 1}`}
            value={question.question}
            onChange={(e) => handleInputChange(e, questionIndex, 0)}
            className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:border-blue-400"
          />
          <ul>
            {question.answers.map((answer, answerIndex) => (
              <li key={answerIndex} className="flex items-center mb-0">
                <input
                  type="text"
                  name="answer"
                  placeholder={`Answer ${answerIndex + 1}`}
                  value={answer.answer}
                  onChange={(e) => {
                    const updatedQuizData = { ...quizData };
                    updatedQuizData.questions[questionIndex].answers[answerIndex].answer = e.target.value;
                    setQuizData(updatedQuizData);
                  }}
                  className="w-full border rounded-md mt-2 p-0 focus:outline-none focus:ring focus:border-blue-400"
                />
                <label className="ml-2">
                  <input
                    type="checkbox"
                    name="is_correct"
                    checked={answer.is_correct}
                    onChange={(e) => handleInputChange(e, questionIndex, answerIndex)}
                  />
                  
                </label>
              </li>
            ))}
          </ul>
        </div>
      ))}
      <button onClick={handleAddQuestion} className="bg-blue-500 text-white rounded-md p-2">
        Add Question
      </button>
      <button onClick={handleSubmit} className="bg-green-500 text-white rounded-md p-2 ml-4">
        Create
      </button>
    </div>
  );
}


export default CreateQuiz;
