import { useNavigate } from "react-router";

function Login() {
  const navigate = useNavigate();

  const handleLogin = (event: React.FormEvent) => {
    event.preventDefault();
    // Get the form values
    const form = event.currentTarget as HTMLFormElement;
    const username = form.username.value;
    const password = form.password.value;

    // Check if username is valid and password is correct
    const validUsernames = ["guest", "user", "player", "admin"];
    if (!validUsernames.includes(username) || password !== "password") {
      alert("Invalid username or password");
      return;
    }

    // Set token to the username
    document.cookie = `TOKEN=${username}; path=/`;
    window.location.href = "/";

    // Navigate to the home page
    navigate("/");
  };

  return (
    <div className="flex min-h-screen items-center justify-center bg-gray-50">
      <div className="w-full max-w-md rounded-lg bg-white p-8 shadow-md">
        <h2 className="mb-6 text-center text-2xl font-bold text-gray-800">
          Login
        </h2>
        <form onSubmit={handleLogin} className="space-y-6">
          <div>
            <label className="block text-sm font-medium text-gray-700">
              Username:
              <input
                type="text"
                name="username"
                className="mt-1 block w-full rounded-md border border-gray-300 px-3 py-2 shadow-sm focus:border-indigo-500 focus:outline-none focus:ring-indigo-500"
              />
            </label>
          </div>
          <div>
            <label className="block text-sm font-medium text-gray-700">
              Password:
              <input
                type="password"
                name="password"
                className="mt-1 block w-full rounded-md border border-gray-300 px-3 py-2 shadow-sm focus:border-indigo-500 focus:outline-none focus:ring-indigo-500"
              />
            </label>
          </div>
          <button
            type="submit"
            className="w-full rounded-md bg-indigo-600 px-4 py-2 text-sm font-medium text-white hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2"
          >
            Login
          </button>
        </form>
      </div>
    </div>
  );
}

export default Login;
