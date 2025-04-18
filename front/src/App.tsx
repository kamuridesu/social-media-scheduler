// import { useState } from 'react'
// import reactLogo from './assets/react.svg'
// import viteLogo from '/vite.svg'
import './App.css'
import { HomePage } from './components/home/home'
import ProtectedRoute from './components/ProtectedRoute'
// import LoginPage from './components/LoginPage';
// import { getCookie } from './utils/cookies';

function App() {

  return (
    <ProtectedRoute>
      <HomePage></HomePage>
    </ProtectedRoute>
  )
}

export default App
