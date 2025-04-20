import {
  Navigate,
  Route,
  BrowserRouter as Router,
  Routes,
} from "react-router-dom";
import "./App.css";
import Home from "./Home";
import Login from "./Login";

function App() {
  return (
    <Router>
      <Routes>
        <Route
          path="/"
          element={
            document.cookie
              .split(";")
              .some((c) => c.trim().startsWith("TOKEN=")) ? (
              <Home />
            ) : (
              <Navigate to="/login" replace />
            )
          }
        />
        <Route path="/login" element={<Login />} />
      </Routes>
    </Router>
  );
}

export default App;
