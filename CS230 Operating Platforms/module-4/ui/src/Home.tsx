import * as React from "react";
import { useNavigate } from "react-router-dom";
import { GameUserInfo } from "./types";

function Home() {
  const navigate = useNavigate();
  const [users, setUsers] = React.useState<GameUserInfo[]>([]);
  const [selectedUser, setSelectedUser] = React.useState<GameUserInfo | null>(
    null,
  );

  const [createFormData, setCreateFormData] = React.useState<
    Omit<GameUserInfo, "id">
  >({
    firstName: "",
    lastName: "",
    email: "",
  });

  const [updateFormData, setUpdateFormData] = React.useState<GameUserInfo>({
    id: 0,
    firstName: "",
    lastName: "",
    email: "",
  });

  const username = document.cookie
    .split("; ")
    .find((row) => row.startsWith("TOKEN="))
    ?.split("=")[1];

  const getNextId = () => {
    if (users.length === 0) return 1;
    return Math.max(...users.map((user: GameUserInfo) => user.id)) + 1;
  };

  const fetchUsers = async () => {
    try {
      const response = await fetch("http://localhost:8080/gameusers", {
        headers: {
          Authorization: "Basic " + btoa(`${username}:password`),
        },
      });
      if (response.ok) {
        const data = await response.json();
        setUsers(data);
      }
    } catch (error) {
      console.error("Error fetching users:", error);
    }
  };

  const fetchUserById = async (id: number) => {
    try {
      const response = await fetch(`http://localhost:8080/gameusers/${id}`, {
        headers: {
          Authorization: "Basic " + btoa(`${username}:password`),
        },
      });
      if (response.ok) {
        const data = await response.json();
        setSelectedUser(data);
        setUpdateFormData({
          id: data.id,
          firstName: data.firstName,
          lastName: data.lastName,
          email: data.email,
        });
      } else {
        setSelectedUser(null);
        alert("User not found");
      }
    } catch (error) {
      console.error("Error fetching user:", error);
    }
  };

  const createUser = async (userData: Omit<GameUserInfo, "id">) => {
    const newUser: GameUserInfo = {
      id: getNextId(),
      ...userData,
    };

    try {
      const response = await fetch("http://localhost:8080/gameusers", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: "Basic " + btoa(`${username}:password`),
        },
        body: JSON.stringify(newUser),
      });

      if (response.ok) {
        fetchUsers();
        setCreateFormData({ firstName: "", lastName: "", email: "" });
        alert("User created successfully");
      } else {
        alert("Failed to create user");
      }
    } catch (error) {
      console.error("Error creating user:", error);
    }
  };

  const updateUser = async (id: number, userData: GameUserInfo) => {
    try {
      const response = await fetch(`http://localhost:8080/gameusers/${id}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
          Authorization: "Basic " + btoa(`${username}:password`),
        },
        body: JSON.stringify(userData),
      });

      if (response.ok) {
        fetchUsers();
        setSelectedUser(null);
        setUpdateFormData({ id: 0, firstName: "", lastName: "", email: "" });
        alert("User updated successfully");
      } else {
        alert("Failed to update user");
      }
    } catch (error) {
      console.error("Error updating user:", error);
    }
  };

  const deleteUser = async (id: number) => {
    try {
      const response = await fetch(`http://localhost:8080/gameusers/${id}`, {
        method: "DELETE",
        headers: {
          Authorization: "Basic " + btoa(`${username}:password`),
        },
      });

      if (response.ok) {
        fetchUsers();
        alert("User deleted successfully");
      } else {
        alert("Failed to delete user");
      }
    } catch (error) {
      console.error("Error deleting user:", error);
    }
  };

  React.useEffect(() => {
    fetchUsers();
  }, []);

  const handleCreateChange = (e: {
    target: { name: string; value: string };
  }) => {
    setCreateFormData({
      ...createFormData,
      [e.target.name]: e.target.value,
    });
  };

  const handleUpdateChange = (e: {
    target: { name: string; value: string | number };
  }) => {
    setUpdateFormData({
      ...updateFormData,
      [e.target.name]: e.target.value,
    });
  };

  return (
    <main className="min-h-screen bg-gray-50 p-4">
      <div className="mb-6 flex items-center justify-between bg-white p-4 shadow-md rounded-lg">
        <h1 className="text-2xl font-bold text-gray-800">
          Welcome, {username}
        </h1>
        <button
          onClick={() => {
            document.cookie =
              "TOKEN=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/";
            navigate("/login");
          }}
          className="rounded-md bg-red-600 px-4 py-2 text-sm font-medium text-white hover:bg-red-700 focus:outline-none focus:ring-2 focus:ring-red-500 focus:ring-offset-2"
        >
          Logout
        </button>
      </div>

      <div className="mb-6 bg-white p-6 shadow-md rounded-lg">
        <h2 className="text-xl font-bold mb-3 text-gray-800">
          Game User Management Dashboard
        </h2>

        <p className="mb-4 text-gray-600">
          This dashboard demonstrates all available CRUD operations for the Game
          User API. Use this interface to create, read, update, and delete user
          records in the system.
        </p>

        <div className="bg-blue-50 p-4 rounded-md border border-blue-200">
          <h3 className="font-bold text-blue-800 mb-2">Instructions:</h3>
          <ul className="list-disc pl-5 space-y-1 text-sm text-gray-700">
            <li>
              <strong>Create:</strong> Fill in the form in the green section to
              add a new user
            </li>
            <li>
              <strong>Read:</strong> Use the blue section to view all users or
              search for a specific user by ID
            </li>
            <li>
              <strong>Update:</strong> Load a user by ID in the yellow section,
              modify their details, and save
            </li>
            <li>
              <strong>Delete:</strong> Enter a user ID in the red section to
              permanently remove a user
            </li>
          </ul>
          <p className="mt-3 text-sm text-gray-500 italic">
            Note: This interface is for demonstration purposes only to showcase
            the API functionality.
          </p>
        </div>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-4">
        <div className="bg-white p-4 rounded-lg shadow">
          <h2 className="text-xl font-bold mb-4 text-green-700">CREATE</h2>
          <form
            onSubmit={(e) => {
              e.preventDefault();
              createUser(createFormData);
            }}
            className="space-y-3"
          >
            <div>
              <label className="block text-sm font-medium">First Name:</label>
              <input
                type="text"
                name="firstName"
                value={createFormData.firstName}
                onChange={handleCreateChange}
                className="w-full p-2 border rounded"
              />
            </div>
            <div>
              <label className="block text-sm font-medium">Last Name:</label>
              <input
                type="text"
                name="lastName"
                value={createFormData.lastName}
                onChange={handleCreateChange}
                className="w-full p-2 border rounded"
              />
            </div>
            <div>
              <label className="block text-sm font-medium">Email:</label>
              <input
                type="email"
                name="email"
                value={createFormData.email}
                onChange={handleCreateChange}
                className="w-full p-2 border rounded"
              />
            </div>
            <button
              type="submit"
              className="w-full bg-green-600 text-white p-2 rounded hover:bg-green-700"
            >
              Create User
            </button>
          </form>
        </div>

        <div className="bg-white p-4 rounded-lg shadow">
          <h2 className="text-xl font-bold mb-4 text-blue-700">READ</h2>
          <div className="mb-4">
            <h3 className="text-lg font-semibold mb-2">Get All Users</h3>
            <button
              onClick={fetchUsers}
              className="w-full bg-blue-600 text-white p-2 rounded hover:bg-blue-700 mb-2"
            >
              Fetch All Users
            </button>
            <div className="max-h-60 overflow-y-auto">
              <ul className="divide-y">
                {users.map((user: GameUserInfo) => (
                  <li
                    key={user.id}
                    className="py-2 cursor-pointer hover:bg-gray-100"
                    onClick={() => {
                      setUpdateFormData({
                        id: user.id,
                        firstName: user.firstName,
                        lastName: user.lastName,
                        email: user.email,
                      });
                    }}
                  >
                    <strong>ID: {user.id}</strong> - {user.firstName}{" "}
                    {user.lastName} ({user.email})
                  </li>
                ))}
              </ul>
            </div>
          </div>
          <div>
            <h3 className="text-lg font-semibold mb-2">Get User by ID</h3>
            <div className="flex gap-2">
              <input
                type="text"
                placeholder="Enter user ID"
                className="flex-1 p-2 border rounded"
                value={updateFormData.id}
                onChange={(e) =>
                  setUpdateFormData({ ...updateFormData, id: +e.target.value })
                }
              />
              <button
                onClick={() => fetchUserById(updateFormData.id)}
                className="bg-blue-600 text-white p-2 rounded hover:bg-blue-700"
              >
                Fetch
              </button>
            </div>
            {selectedUser && (
              <div className="mt-2 p-2 bg-gray-100 rounded">
                <p>
                  <strong>ID:</strong> {selectedUser.id}
                </p>
                <p>
                  <strong>Name:</strong> {selectedUser.firstName}{" "}
                  {selectedUser.lastName}
                </p>
                <p>
                  <strong>Email:</strong> {selectedUser.email}
                </p>
              </div>
            )}
          </div>
        </div>

        <div className="bg-white p-4 rounded-lg shadow">
          <h2 className="text-xl font-bold mb-4 text-yellow-700">UPDATE</h2>
          <div className="mb-3">
            <label className="block text-sm font-medium">
              User ID to Update:
            </label>
            <div className="flex gap-2">
              <input
                type="text"
                value={updateFormData.id}
                onChange={(e) =>
                  setUpdateFormData({ ...updateFormData, id: +e.target.value })
                }
                className="flex-1 p-2 border rounded"
                placeholder="Enter ID"
              />
              <button
                onClick={() => fetchUserById(updateFormData.id)}
                className="bg-yellow-600 text-white p-2 rounded hover:bg-yellow-700"
              >
                Load
              </button>
            </div>
          </div>
          <form
            onSubmit={(e) => {
              e.preventDefault();
              updateUser(updateFormData.id, updateFormData);
            }}
            className="space-y-3"
          >
            <div>
              <label className="block text-sm font-medium">First Name:</label>
              <input
                type="text"
                name="firstName"
                value={updateFormData.firstName}
                onChange={handleUpdateChange}
                className="w-full p-2 border rounded"
              />
            </div>
            <div>
              <label className="block text-sm font-medium">Last Name:</label>
              <input
                type="text"
                name="lastName"
                value={updateFormData.lastName}
                onChange={handleUpdateChange}
                className="w-full p-2 border rounded"
              />
            </div>
            <div>
              <label className="block text-sm font-medium">Email:</label>
              <input
                type="email"
                name="email"
                value={updateFormData.email}
                onChange={handleUpdateChange}
                className="w-full p-2 border rounded"
              />
            </div>
            <button
              type="submit"
              className="w-full bg-yellow-600 text-white p-2 rounded hover:bg-yellow-700"
            >
              Update User
            </button>
          </form>
        </div>

        <div className="bg-white p-4 rounded-lg shadow">
          <h2 className="text-xl font-bold mb-4 text-red-700">DELETE</h2>
          <div className="mb-3">
            <label className="block text-sm font-medium">
              User ID to Delete:
            </label>
            <div className="flex gap-2">
              <input
                type="text"
                placeholder="Enter ID to delete"
                className="flex-1 p-2 border rounded"
                value={updateFormData.id}
                onChange={(e) =>
                  setUpdateFormData({ ...updateFormData, id: +e.target.value })
                }
              />
              <button
                onClick={() => fetchUserById(updateFormData.id)}
                className="bg-blue-600 text-white p-2 rounded hover:bg-blue-700"
              >
                Find User
              </button>
            </div>
          </div>

          {selectedUser && (
            <div className="my-4 p-3 bg-gray-100 rounded">
              <p>
                <strong>ID:</strong> {selectedUser.id}
              </p>
              <p>
                <strong>Name:</strong> {selectedUser.firstName}{" "}
                {selectedUser.lastName}
              </p>
              <p>
                <strong>Email:</strong> {selectedUser.email}
              </p>
            </div>
          )}

          <button
            onClick={() => {
              if (
                updateFormData.id &&
                confirm(
                  `Are you sure you want to delete user with ID ${updateFormData.id}?`,
                )
              ) {
                deleteUser(updateFormData.id);
                setSelectedUser(null);
              } else if (!updateFormData.id) {
                alert("Please enter a user ID to delete");
              }
            }}
            className="w-full bg-red-600 text-white p-2 rounded hover:bg-red-700 mt-4"
          >
            Delete User
          </button>

          <div className="mt-4">
            <p className="text-sm text-gray-600">
              Deleting a user will permanently remove all their data from the
              system. This action cannot be undone.
            </p>
          </div>
        </div>
      </div>
    </main>
  );
}

export default Home;
