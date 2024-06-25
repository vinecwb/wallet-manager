import { Request, Response } from 'express';
import prisma from '../prisma/client';

export const createWallet = async (req: Request, res: Response): Promise<void> => {
  try {
    const { amount, userId, status } = req.body;

    if (!amount || !userId || !status) {
      res.status(400).json({ error: "Missing required fields" });
      return;
    }

    const newWallet = await prisma.wallet.create({
      data: { amount, userId, status }
    });

    res.status(201).json(newWallet);
  } catch (error) {
    res.status(500).json({ error: "Internal server error" });
  }
};
