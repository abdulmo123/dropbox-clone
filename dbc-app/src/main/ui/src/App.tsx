import './App.css'
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import NavAppBar from './components/NavAppBar';
import SignupPage from './pages/SignupPage';
import HomePage from './pages/HomePage';

function App() {

  return (
    <BrowserRouter>
      <NavAppBar />
      <Routes>
        <Route path="/home" element={<HomePage />}></Route>
        <Route path="/signup" element={<SignupPage />}></Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App
