import { Router } from 'express';
import { createWallet } from '../controllers/walletController';

const router = Router();

router.post('/wallets', createWallet);

export default router;
