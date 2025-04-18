import { capitalize } from "@/utils/textUtils";
import React from "react";

type Props = {
    name: string;
    property: string;
    isPassword?: boolean
    setProperty: React.Dispatch<React.SetStateAction<string>>;
}

export function LoginInput(props: Props) {
    return (
        <>
        <label
            htmlFor={`${props.name}`}
            className="block text-gray-700 text-sm font-semibold mb-2 ">
            {capitalize(props.name)}
        </label>
        <input
            type={props.isPassword ? "password" : "text"}
            id="username"
            value={props.property}
            onChange={(e) => props.setProperty(e.target.value)}
            className="px-3 border bg-gray-300 border-gray-400 rounded-lg focus:outline-none focus:border-primary justify-center text-center"
            required
        />
        </>
    )
}
